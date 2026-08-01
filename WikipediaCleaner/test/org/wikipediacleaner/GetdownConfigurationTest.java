package org.wikipediacleaner;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class GetdownConfigurationTest {

  @Test
  public void requiresJava17() throws IOException {
    String configuration = Files.readString(Path.of("resources/getdown/getdown.txt"));

    String version = configuration.lines()
        .filter(line -> line.startsWith("java_min_version = "))
        .findFirst()
        .orElseThrow();

    assertEquals("java_min_version = 1170000", version);
  }
}
