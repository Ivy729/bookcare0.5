// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    // ...

    // Add the dependency for the Google services Gradle plugin
    alias(libs.plugins.android.application) apply false
}