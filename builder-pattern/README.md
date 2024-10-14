## Problem Statement
You are tasked with building a Computer using the Builder Pattern. The computer should have required fields such as CPU and RAM, and optional fields such as Graphics Card and SSD.

### Problem Requirements

1. **Computer (Product Class)**:
    - Create a `Computer` class with required fields:
        - `String CPU`: CPU of the computer.
        - `String RAM`: RAM of the computer.
    - Include optional fields:
        - `String graphicsCard`: Graphics card of the computer.
        - `String ssd`: SSD of the computer.
2. **ComputerBuilder (Builder Class)**:
    - Create a nested `ComputerBuilder` class that sets the required and optional fields.
3. **Build Method**:
    - Add a `build()` method to return the final `Computer` object.
4. **Client Code**:
    - Demonstrate how different types of computers can be built using the builder pattern (e.g., with or without graphics card, with or without SSD).