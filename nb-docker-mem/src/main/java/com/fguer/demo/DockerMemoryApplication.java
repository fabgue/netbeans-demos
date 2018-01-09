package com.fguer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DockerMemoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DockerMemoryApplication.class, args);
    }
}

@RestController
@RequestMapping("/api")
class MyController {

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/hello", produces = "text/plain")
    public String hello() {
        String hostname = System.getenv().getOrDefault("HOSTNAME", "Unknown");
        return String.format("Hello world from %s", hostname);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/memory", produces = "text/plain")
    public String memory() {
        System.out.println("Starting to allocate memory...");
        Runtime rt = Runtime.getRuntime();
        StringBuilder sb = new StringBuilder();
        long maxMemory = rt.maxMemory();
        long usedMemory = 0;
        while (((float) usedMemory / maxMemory) < 0.80) {
            sb.append(System.nanoTime()).append(sb.toString());
            usedMemory = rt.totalMemory();
        }
        String msg = "Allocated more than 80% (" + humanReadableByteCount(usedMemory, false) + ") of the max allowed JVM memory size ("
                + humanReadableByteCount(maxMemory, false) + ")";
        System.out.println(msg);
        return msg;
    }

    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/health")
    public String health() {
        return "I'm OK";
    }

}
