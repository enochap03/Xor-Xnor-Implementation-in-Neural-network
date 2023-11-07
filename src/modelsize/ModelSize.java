package modelsize;

import java.lang.instrument.Instrumentation;

public class ModelSize {
	private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }

}
