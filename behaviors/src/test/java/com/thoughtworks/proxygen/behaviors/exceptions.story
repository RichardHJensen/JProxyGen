Story: Exceptions are preserved

Scenario: Exception is preserved

Given an interface method
  void hi() throws java.io.IOException
When a null class is generated
Then it is the equivalent of
  public void hi() throws java.io.IOException {
  }

Scenario: More than Exception is preserved

Given an interface method
  void hi() throws java.io.IOException, InterruptedException
When a null class is generated
Then it is the equivalent of
  public void hi() throws java.io.IOException, InterruptedException {
  }

Scenario: Runtime Exception is preserved

Given an interface method
  void hi() throws RuntimeException
When a null class is generated
Then it is the equivalent of
  public void hi() throws RuntimeException {
  }

Scenario: Error is preserved

Given an interface method
  void hi() throws Error
When a null class is generated
Then it is the equivalent of
  public void hi() throws Error {
  }

Scenario: Throwable is preserved

Given an interface method
  void hi() throws Throwable
When a null class is generated
Then it is the equivalent of
  public void hi() throws Throwable {
  }
