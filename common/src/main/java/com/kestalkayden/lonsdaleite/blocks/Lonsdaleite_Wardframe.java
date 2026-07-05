package com.kestalkayden.lonsdaleite.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

/**
 * A crystal wardframe that only players can pass through.
 *
 * Collision is resolved per-entity: players, tamed animals, and anything carrying a
 * player as a passenger (horses, boats, minecarts) fall through to an empty shape,
 * while every other entity collides with the full cube. Mob pathfinding evaluates
 * collision without an entity context, so hostiles see a solid wall and never even
 * try to path through the doorway.
 *
 * Adjacent wardframes auto-merge into one structure, hydrofarm tank style: six
 * connection booleans drive a multipart blockstate that only draws beam pieces on
 * unconnected edges, so a stack or wall of wardframes renders as a single frame
 * around the whole opening with an invisible (but still mob-proof) interior.
 */
public class Lonsdaleite_Wardframe extends Block {
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty EAST  = BlockStateProperties.EAST;
    public static final BooleanProperty WEST  = BlockStateProperties.WEST;
    public static final BooleanProperty UP    = BlockStateProperties.UP;
    public static final BooleanProperty DOWN  = BlockStateProperties.DOWN;

    public Lonsdaleite_Wardframe(Properties properties) {
        super(properties);
        registerDefaultState(stateDefinition.any()
            .setValue(NORTH, false).setValue(SOUTH, false)
            .setValue(EAST,  false).setValue(WEST,  false)
            .setValue(UP,    false).setValue(DOWN,  false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, SOUTH, EAST, WEST, UP, DOWN);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        return defaultBlockState()
            .setValue(NORTH, isWardframe(context.getLevel().getBlockState(pos.north())))
            .setValue(SOUTH, isWardframe(context.getLevel().getBlockState(pos.south())))
            .setValue(EAST,  isWardframe(context.getLevel().getBlockState(pos.east())))
            .setValue(WEST,  isWardframe(context.getLevel().getBlockState(pos.west())))
            .setValue(UP,    isWardframe(context.getLevel().getBlockState(pos.above())))
            .setValue(DOWN,  isWardframe(context.getLevel().getBlockState(pos.below())));
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTick,
                                      BlockPos pos, Direction direction, BlockPos neighborPos,
                                      BlockState neighborState, RandomSource random) {
        BooleanProperty prop = propertyForDirection(direction);
        return prop == null ? state : state.setValue(prop, isWardframe(neighborState));
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (context instanceof EntityCollisionContext entityContext && mayPassThrough(entityContext.getEntity())) {
            return Shapes.empty();
        }
        return Shapes.block();
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType type) {
        // Mobs always treat the frame as a wall - no pressing against the doorway.
        return false;
    }

    private static boolean isWardframe(BlockState state) {
        return state.getBlock() instanceof Lonsdaleite_Wardframe;
    }

    private static boolean mayPassThrough(Entity entity) {
        if (entity == null) {
            return false;
        }
        if (entity instanceof Player) {
            return true;
        }
        if (entity instanceof TamableAnimal tamable && tamable.isTame()) {
            return true;
        }
        // Mounts and vehicles pass while a player is aboard.
        return entity.hasPassenger(passenger -> passenger instanceof Player);
    }

    private static BooleanProperty propertyForDirection(Direction direction) {
        return switch (direction) {
            case NORTH -> NORTH;
            case SOUTH -> SOUTH;
            case EAST  -> EAST;
            case WEST  -> WEST;
            case UP    -> UP;
            case DOWN  -> DOWN;
        };
    }
}
