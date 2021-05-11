package com.ziya.jvm.hotspot.src.share.selfvm;

import cn.hutool.core.util.StrUtil;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.List;

public class Main {


    @Parameter(names={"-version", "-v"})
    boolean version;
    @Parameter(names={"-help", "-h"})
    boolean help;
    @Parameter(names={"-classpath", "-cp"}, variableArity = true)
    List<String> cps = new ArrayList<>();
    public static void main(String[] args) {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        if (main.version) { //print version and exit
            System.out.println("version 0.0.1");
        }
        if (main.help) {
            System.out.print("Usage:");
            System.out.print(" -version");
            System.out.println(" -cp");
        }
        String classpath = main.cps.get(0);
        if (StrUtil.isNotBlank(classpath)) {
            System.out.print("classpath:"+ classpath+" args: ");
            for (int i = 1; i < main.cps.size(); i++) {
                System.out.print(main.cps.get(i)+" ");
            }
            System.out.println();
        }

        startJVM();
    }

    private static void startJVM() {


    }

}
