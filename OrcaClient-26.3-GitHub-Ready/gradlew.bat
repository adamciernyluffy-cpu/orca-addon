@echo off
setlocal EnableExtensions
set "GRADLE_VERSION=9.6.0"
set "BASE=%~dp0.gradle-bootstrap"
set "DIST=%BASE%\gradle-%GRADLE_VERSION%-bin.zip"
set "HOME_DIR=%BASE%\gradle-%GRADLE_VERSION%"

if not exist "%HOME_DIR%\bin\gradle.bat" (
    echo Gradle %GRADLE_VERSION% is not installed for this project.
    echo Downloading Gradle from services.gradle.org...
    if not exist "%BASE%" mkdir "%BASE%"
    powershell -NoProfile -ExecutionPolicy Bypass -Command "$ProgressPreference='SilentlyContinue'; Invoke-WebRequest -UseBasicParsing -Uri 'https://services.gradle.org/distributions/gradle-9.6.0-bin.zip' -OutFile '%DIST%'"
    if errorlevel 1 (
        echo Failed to download Gradle.
        exit /b 1
    )
    powershell -NoProfile -ExecutionPolicy Bypass -Command "Expand-Archive -LiteralPath '%DIST%' -DestinationPath '%BASE%' -Force"
    if errorlevel 1 (
        echo Failed to extract Gradle.
        exit /b 1
    )
)

call "%HOME_DIR%\bin\gradle.bat" %*
exit /b %ERRORLEVEL%
