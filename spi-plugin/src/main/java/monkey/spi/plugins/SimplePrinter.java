package monkey.spi.plugins;

import monkey.spi.service.Printer;

public class SimplePrinter implements Printer {

    public void print(String value) {
        System.out.println("value: " + value);
    }
}
