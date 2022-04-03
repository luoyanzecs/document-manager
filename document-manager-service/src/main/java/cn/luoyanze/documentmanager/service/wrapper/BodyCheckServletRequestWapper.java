package cn.luoyanze.documentmanager.service.wrapper;

import org.jooq.tools.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Optional;

/**
 * @Author luoyanze[luoyanzeze@icloud.com]
 * @Date 2022/4/3 7:24 PM
 */

public class BodyCheckServletRequestWapper extends HttpServletRequestWrapper {

    private static final Logger logger = LoggerFactory.getLogger(BodyCheckServletRequestWapper.class);

    private byte[] requestBody;
    private Charset charSet;

    public BodyCheckServletRequestWapper(HttpServletRequest request) {
        super(request);

        try {
            String str = getRequestPostStr(request);
            requestBody = StringUtils.isEmpty(str) ? new byte[0] : str.getBytes(charSet);
        } catch (IOException e) {
            logger.error("", e);
        }
    }

    public String getRequestPostStr(HttpServletRequest request) throws IOException {
        String charSetStr = Optional.ofNullable(request.getCharacterEncoding()).orElse("UTF-8");
        charSet = Charset.forName(charSetStr);
        return StreamUtils.copyToString(request.getInputStream(), charSet);
    }

    /**
     * 重写 getInputStream()
     */
    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream byteArrayInputStream =
                new ByteArrayInputStream(Optional.ofNullable(requestBody).orElse(new byte[0]));

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() {
                return byteArrayInputStream.read();
            }
        };
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }
}
