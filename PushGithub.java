package com.mycompany.assignment1new;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;

public class PushGithub {

    public void runGit() throws IOException {
        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd && cd \"C:\\Users\\ROG_PC\\243102-STIW3054-A172-A1.wiki\" && git add * && git commit -m \"Test\" && git pull && git push");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            System.out.println("\nGIT result : \n");
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
            sleep(3000);
        } catch (Exception e) {
            System.out.println("Terminal cant open !");
        }
    }
}
