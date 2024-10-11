## Problem Statement

You are tasked with creating a Configuration Manager for an application using the Singleton Pattern. The configuration should be loaded only once and made accessible throughout the application.

### Problem Requirements

1. **Configuration (Singleton Class)**:
    - Create a `Configuration` class that holds application settings.
    - Make the constructor private and provide a method `getInstance()` to return the single instance.
2. **Configuration Methods**:
    - Include methods to get and set configuration values, such as:
        - `String getSetting(String key)`: returns the value for the given key.
        - `void setSetting(String key, String value)`: sets the value for the given key.
3. **Client Code**:
    - Demonstrate how the configuration can be accessed and modified from different parts of the application, ensuring that changes reflect across all accesses.