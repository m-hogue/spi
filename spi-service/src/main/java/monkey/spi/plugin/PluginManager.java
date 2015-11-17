package monkey.spi.plugin;

import monkey.spi.service.Printer;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.ServiceLoader;

public class PluginManager {

    public static void main(String[] args)
            throws MalformedURLException {
        System.out.println("loading printers...");
        // point at spi-plugin module's target dir
        File loc = new File("spi-plugin/target");

        // use URL classloader to grab jars
        File[] flist = loc.listFiles(new FileFilter() {
            public boolean accept(File file) {return file.getPath().toLowerCase().endsWith(".jar");}
        });
        System.out.println("found " + flist.length + " jars.");
        URL[] urls = new URL[flist.length];
        for (int i = 0; i < flist.length; i++)
            urls[i] = flist[i].toURI().toURL();
        URLClassLoader ucl = new URLClassLoader(urls);

        ServiceLoader<Printer> printers = ServiceLoader.load(Printer.class, ucl);

        Iterator<Printer> iter = printers.iterator();
        while(iter.hasNext()) {
            iter.next().print("Hello World");
        }
    }
}
