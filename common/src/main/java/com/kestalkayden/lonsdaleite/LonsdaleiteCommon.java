package com.kestalkayden.lonsdaleite;

/**
 * Loader-agnostic constants shared by the common source set.
 *
 * <p>Holds {@link #MOD_ID} so platform-agnostic code (e.g. material/tag resource keys) doesn't have
 * to reference the loader-specific {@code Lonsdaleite} entry point, which lives only in the Fabric
 * and NeoForge source sets. Keeping that reference out of {@code common/} is what lets the
 * {@code :common} purity gate compile against vanilla NeoForm with no loader on the classpath.
 */
public final class LonsdaleiteCommon {
    private LonsdaleiteCommon() {}

    public static final String MOD_ID = "lonsdaleite";
}
