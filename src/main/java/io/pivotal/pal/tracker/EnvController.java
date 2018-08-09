package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    public String port_number="";
    public String memLimit="";
    public String cfInstanceIndex="";
    public String cfInstanceAddress="";
    public EnvController(
            @Value("${PORT:NOT SET}") String port,
            @Value("${MEMORY_LIMIT:NOT SET}") String mem_Limit_value,
            @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfIIndex,
            @Value("${CF_INSTANCE_ADDR:NOT SET}") String cfInstAddress
    ) {
        this.port_number = port;
        this.memLimit = mem_Limit_value;
        this.cfInstanceIndex = cfIIndex;
        this.cfInstanceAddress = cfInstAddress;
    }


    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> env = new HashMap<>();
        env.put("PORT", port_number);
        env.put("MEMORY_LIMIT", memLimit);
        env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR", cfInstanceAddress);
        return env;
    }
}
