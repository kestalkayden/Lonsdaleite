# Lonsdaleite Tools

A small expansion mod that adds **Lonsdaleite**, a tier above diamond — an alternative path to Netherite for players who'd rather skip the Nether. Crafting costs a hefty amount of diamond (via the gem chain), and repairs eat more of the gem itself, so make good use of enchantments.

## Requirements

- Minecraft **26.1.x**
- Java **25**
- Fabric Loader **0.18.4+** with **Fabric API**, *or* NeoForge **26.1+**

## Downloads

- Modrinth: <https://modrinth.com/mod/lonsdaleite-tools>
- CurseForge: <https://www.curseforge.com/minecraft/mc-mods/lonsdaleite>

Back up your world before installing new versions. It's a small mod and shouldn't break anything, but better safe than sorry.

## What's in it

- **Material chain:** Raw → Prepared → Refined Gem → Perfect Gem.
- **Tools (×2 tiers):** pickaxe, axe, shovel, hoe, omnitool.
- **Weapons (×2 tiers):** sword, dagger, war axe.
- **Armor (×2 tiers):** full helmet/chestplate/leggings/boots sets.

Items appear in their own creative tab and are also injected into the vanilla Ingredients / Tools / Combat tabs near their Netherite counterparts.

## Building

```bash
./gradlew buildAll
```

Produces:
- `fabric/build/libs/lonsdaleite-fabric-<version>.jar`
- `neoforge/build/libs/lonsdaleite-neoforge-<version>.jar`

Individual loaders: `./gradlew :fabric:build` or `./gradlew :neoforge:build`.

Dev clients: `./gradlew :fabric:runClient` or `./gradlew :neoforge:runClient`.

## Repo layout

```
shared-resources/   assets, recipes, tags, lang — shared between both loaders
fabric/             Fabric loader subproject
neoforge/           NeoForge loader subproject
```

The Java source classes that don't touch loader-specific APIs (item/material implementations) live in both subprojects' `src/main/java/` and are byte-identical between them, since Minecraft 26.1 ships deobfuscated and uses Mojang's official names on both sides.

## License

CC0-1.0.
