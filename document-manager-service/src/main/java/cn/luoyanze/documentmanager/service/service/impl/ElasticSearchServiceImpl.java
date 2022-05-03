package cn.luoyanze.documentmanager.service.service.impl;

import cn.luoyanze.documentmanager.common.contract.SearchHttpRequest;
import cn.luoyanze.documentmanager.common.contract.SearchHttpResponse;
import cn.luoyanze.documentmanager.common.contract.common.ResponseHead;
import cn.luoyanze.documentmanager.common.model.HeadStatus;
import cn.luoyanze.documentmanager.service.search.LuceneIndexManager;
import cn.luoyanze.documentmanager.service.service.ElasticSearchService;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/10 1:50 AM
 */

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {

    private final static Logger LOGGER = LoggerFactory.getLogger(ElasticSearchServiceImpl.class);

    private final LuceneIndexManager luceneIndexManager;

    public ElasticSearchServiceImpl(LuceneIndexManager luceneIndexManager) {
        this.luceneIndexManager = luceneIndexManager;
    }

    @Override
    public SearchHttpResponse execute(SearchHttpRequest request) {
        SearchHttpResponse resp = new SearchHttpResponse();

        List<SearchHttpResponse.Result> res
                = luceneIndexManager.search(request.getInput())
                .stream().map(it ->
                        new SearchHttpResponse.Result()
                                .setId(it.getFileId())
                                .setAuthor(it.getAuthor())
                                .setTitle(highLight(it.getTitle(), request.getInput()))
                                .setCtx(highLight(it.getText(), request.getInput()))
                ).collect(Collectors.toList());

        resp.setHead(new ResponseHead(HeadStatus.SUCCESS));
        resp.setSearchResults(res);
        return resp;
    }

    private String highLight(String text, String input)  {
        String res = text;
        Set<String> words = new HashSet<>(getWords(input));
        for (String word : words) {
            res = res.replaceAll(word, "<span style=\"background-color:#FBBF24\">" + word + "</span>");
        }

        return res;
    }

    private List<String> getWords(String input) {
        // 分词
        try {
            IKAnalyzer analyzer = new IKAnalyzer();
            StringReader reader = new StringReader(input);
            TokenStream tokenStream = analyzer.tokenStream("", reader);
            CharTermAttribute attribute = tokenStream.getAttribute(CharTermAttribute.class);
            tokenStream.reset();
            ArrayList<String> words = new ArrayList<>();
            while (tokenStream.incrementToken()) {
                if (attribute.toString().length() >= 2) {
                    words.add(attribute.toString());
                }
            }
            reader.close();
            return words;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
