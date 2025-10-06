# IntelliJ IDEA Translation Plugin (Translate GBK)

[中文版本](README_CN.md)
![Plugin Version](https://img.shields.io/badge/version-1.0--SNAPSHOT-blue)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-232%2B-orange)
![License](https://img.shields.io/badge/license-Apache%202.0-green)

A translation plugin for IntelliJ IDEA that supports translating selected text into Simplified Chinese. Perfect for quickly translating documentation, comments, and other content during development to enhance international development experience.

## Features

- 🌍 Text Translation: Supports translating selected text in any language to Simplified Chinese
- 🔧 Easy to Use: Select text in the editor, right-click and choose "Translate"
- ⚙️ Configurable: Supports configuring Youdao Translation API keys
- 🔒 Secure: Translation through Youdao Cloud API, data security guaranteed

## Installation

### Method 1: Install via IntelliJ IDEA Plugin Marketplace (Recommended)
1. Open IntelliJ IDEA
2. Go to `Preferences` > `Plugins`
3. Search for "Translate GBK" in the Marketplace
4. Click Install and restart IDEA

### Method 2: Manual Installation
1. Download the plugin `.jar` file
2. Open IntelliJ IDEA
3. Go to `Preferences` > `Plugins`
4. Click the gear icon in the upper right corner and select `Install Plugin from Disk...`
5. Select the downloaded `.jar` file and install
6. Restart IntelliJ IDEA

## Usage

1. Open any file in IntelliJ IDEA
2. Select the text you want to translate
3. Right-click the selected text and choose "翻译" (Translate) from the context menu
4. The translation result will be displayed in a popup window

## Configuration

Before using the plugin, you need to configure the Youdao Translation API key:

1. Visit [Youdao Zhiyun](https://ai.youdao.com/) to register an account and create an application
2. Obtain the `App Key` and `App Secret` of the application
3. In IntelliJ IDEA, go to `Preferences` > `Tools` > `Translate Plugin Settings`
4. Enter the obtained `App Key` and `App Secret`
5. Click `OK` to save the configuration

## Technical Architecture

- **Programming Language**: Java/Kotlin
- **Build Tool**: Gradle
- **Dependencies**:
  - [OkHttp3](https://square.github.io/okhttp/): For HTTP requests
  - [FastJSON2](https://github.com/alibaba/fastjson2): For JSON parsing
- **API**: [Youdao Translation API](https://ai.youdao.com/product-fanyi-text.s)

## Development Guide

### Requirements

- JDK 17+
- IntelliJ IDEA 2023.2+

### Building the Project

```bash
# Clone the project
git clone <repository-url>

# Enter the project directory
cd translate-jb-plugin

# Build the plugin
./gradlew buildPlugin
```

After building, the plugin file will be located in the `build/libs/` directory.

### Running for Debugging

```bash
# Run the debug environment
./gradlew runIde
```

## Project Structure

```
src/
├── main/
│   ├── java/com/sun/
│   │   ├── action/              # Action handlers
│   │   ├── config/              # Configuration management
│   │   └── utils/               # Utility classes
│   └── resources/
│       └── META-INF/
│           └── plugin.xml       # Plugin configuration file
```

## Contributing

Feel free to submit Issues and Pull Requests to improve this plugin.

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.