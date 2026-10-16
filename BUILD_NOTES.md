# ProtocolSupportCompat compatibility experiment

This source tree is adjusted to target ViaVersion 5.12.0 (which adds Minecraft 26.3 protocol support), Java 17, and Paper 1.18.2. The project originally pinned ViaVersion 4.10.2 and imported ViaVersion's internal `NMSUtil`, which is not a stable public API and is not present in the newer release.

Changes made:
- Updated compile-only ViaVersion dependencies from 4.10.2 to 5.12.0 and the Paper API target from 1.16.5 to 1.18.2.
- Set this plugin's Java toolchain to 17.
- Replaced the internal ViaVersion `NMSUtil` call with class-name reflection for Paper 1.18.2's `ClientIntentionPacket`, plus older-name fallbacks.
- Quoted `api-version` in `plugin.yml` so the YAML parser treats it as a string. This may fix the `Invalid plugin.yml` error from the previously downloaded artifact.

Important: this modified project has **not been compiled or tested against a live Paper server** in this environment. It is not a ready-to-install JAR yet. The original build requires downloading Gradle and Maven dependencies, but outbound network access is unavailable here. Build it on a machine with Java 17 and network access using:

```bash
./gradlew clean build
```

Then inspect `build/libs/` and test first on a copy of your server. Keep backups of your working ProtocolSupport/ViaVersion setup. Updating the ViaVersion dependency does not by itself guarantee all client versions 1.4.7–26.3 work; this add-on bridges ProtocolSupport with ViaVersion, and runtime compatibility still needs testing.
