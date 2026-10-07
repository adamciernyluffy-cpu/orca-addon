# GitHub build instructions

The repository already contains:

    .github/workflows/build.yml

You do NOT need to choose the GitHub "Java with Gradle" template.

After pushing the project:

1. Click Actions.
2. Click Build Orca Client.
3. Click Run workflow.
4. Wait for the green check.
5. Open the completed run.
6. Scroll to Artifacts.
7. Download `orca-client-26.3`.

The workflow uses Java 25 and Gradle 9.6.
