package cn.luoyanze.documentmanager.service.impl;

import cn.luoyanze.common.contract.CheckHealthHttpRequest;
import cn.luoyanze.common.contract.CheckHealthHttpResponse;
import cn.luoyanze.common.contract.common.ResponseHead;
import cn.luoyanze.common.model.HeadStatus;
import cn.luoyanze.documentmanager.service.CheckHealthService;
import com.sun.management.OperatingSystemMXBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static cn.luoyanze.common.model.HeadStatus.INSERT_USER_FAIL;

/**
 * @author
 * @date 2022/5/2 18:41
 */
@Service
public class CheckHealthServiceimpl implements CheckHealthService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckHealthServiceimpl.class);
    @Override
    public CheckHealthHttpResponse checkHealth() {
        CheckHealthHttpResponse resp = new CheckHealthHttpResponse();
        try{
            Map result = new LinkedHashMap();
            Runtime r = Runtime.getRuntime();
            File[] files = File.listRoots();
            for (File file : files) {
                String total = new DecimalFormat("#.#").format(file.getTotalSpace() * 1.0 / 1024 / 1024 / 1024) + "G";

                String free = new DecimalFormat("#.#").format(file.getFreeSpace() * 1.0 / 1024 / 1024 / 1024) + "G";

                String path = file.getPath();
                result.put(path+"磁盘总空间", total);
                result.put(path+"磁盘空闲空间", free);

            }
            OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
            // 堆内存使用情况
            MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
            // 初始的总内存
            long initTotalMemorySize = memoryUsage.getInit();
            // 最大可用内存
            long maxMemorySize = memoryUsage.getMax();
            // 已使用的内存
            long usedMemorySize = memoryUsage.getUsed();
            // 总的物理内存
            String totalMemorySize = new DecimalFormat("#.##").format(osmxb.getTotalPhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
            // 剩余的物理内存
            String freePhysicalMemorySize = new DecimalFormat("#.##").format(osmxb.getFreePhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
            // 已使用的物理内存
            String usedMemory = new DecimalFormat("#.##").format((osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()) / 1024.0 / 1024 / 1024) + "G";
            String jvmInitMem = new DecimalFormat("#.#").format(initTotalMemorySize * 1.0 / 1024 / 1024) + "M";
            String jvmMaxMem = new DecimalFormat("#.#").format(maxMemorySize * 1.0 / 1024 / 1024) + "M";
            String jvmUsedMem = new DecimalFormat("#.#").format(usedMemorySize * 1.0 / 1024 / 1024) + "M";
            result.put("程序启动时间", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(ManagementFactory.getRuntimeMXBean().getStartTime())));
            result.put("JVM可以使用的处理器个数", r.availableProcessors());
            result.put("物理总内存", totalMemorySize);
            result.put("已使用物理内存", usedMemory);
            result.put("剩余物理内存", freePhysicalMemorySize);
            result.put("JVM可以使用的总内存", new DecimalFormat("#.#").format(r.totalMemory() * 1.0 / 1024 / 1024) + "M");
            result.put("JVM可以使用的剩余内存", new DecimalFormat("#.#").format(r.freeMemory() * 1.0 / 1024 / 1024) + "M");
            result.put("JVM最大可用内存", jvmMaxMem);
            result.put("JVM初始总内存", jvmInitMem);
            result.put("JVM已使用的内存", jvmUsedMem);

            resp.setHead(new ResponseHead(HeadStatus.SUCCESS));
            resp.setItems((LinkedHashMap) result);
            } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
        }
        return resp;
    }
}
