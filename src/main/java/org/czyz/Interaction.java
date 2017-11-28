package org.czyz;

import java.util.function.Consumer;
import java.util.function.Function;

public interface Interaction {
    String action(Consumer<String> message, Consumer<String> onError, Function<String, Boolean> function);
}
