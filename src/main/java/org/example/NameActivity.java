package org.example;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface NameActivity {

    String composeName(String name);
}
