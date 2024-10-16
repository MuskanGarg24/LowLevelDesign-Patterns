## Problem Statement

You are designing a document management system where access to different sections of a document should be controlled based on user roles.

1. **Document**: Represents a document with different sections (e.g., Introduction, Body, Conclusion).
2. **RealDocument**: Implements the actual content and access methods for each section of the document.
3. **DocumentProxy**: Controls access to the `RealDocument` based on the user’s role (e.g., regular user, editor, admin).

### Problem Requirements

1. Implement the `Document` interface with methods to access different sections of the document.
2. Create a `RealDocument` class that provides the actual content for the sections.
3. Create a `DocumentProxy` class that controls access based on the user's role.
4. Implement roles such as:
   - **Regular User**: Can only view the Introduction section.
   - **Editor**: Can view the Introduction and Body sections.
   - **Admin**: Can view all sections (Introduction, Body, Conclusion).
