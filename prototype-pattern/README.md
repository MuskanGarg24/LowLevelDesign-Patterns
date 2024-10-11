## Problem Statement

You are tasked with building a Document Management System using the Prototype Pattern. The system should allow cloning different types of documents: Reports, Letters, and Invoices. The goal is to use the Prototype Design Pattern to enable easy duplication of documents.

### Problem Requirements

1. **Document (Prototype Interface)**:
    - Define an interface for documents with methods:
        - `Document clone()`: returns a clone of the document.
        - `void display()`: prints the document content.
2. **Concrete Document Classes**:
    - Implement concrete classes for different types of documents:
        - **Report**: A report with specific content.
        - **Letter**: A letter with specific content.
        - **Invoice**: An invoice with specific content.
3. **Client Code**:
    - Demonstrate how the prototypes can be used to clone different document types and display their contents.