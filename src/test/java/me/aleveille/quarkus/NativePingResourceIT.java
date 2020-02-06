package me.aleveille.quarkus;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativePingResourceIT extends GreetingResourceTest {

    // Execute the same tests but in native mode.
}
