package goodgenerator.blocks.tileEntity;

import com.github.bartimaeusnek.bartworks.common.loaders.ItemRegistry;
import goodgenerator.blocks.tileEntity.base.LargeFusionComputer;
import goodgenerator.loader.Loaders;
import goodgenerator.util.DescTextLocalization;
import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.render.TextureFactory;
import gregtech.api.util.GT_Multiblock_Tooltip_Builder;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;

import static goodgenerator.util.DescTextLocalization.BLUE_PRINT_INFO;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FUSION2;
import static gregtech.api.enums.Textures.BlockIcons.OVERLAY_FUSION2_GLOW;

public class LargeFusionComputer2 extends LargeFusionComputer {

    private static final ITexture textureOverlay = TextureFactory.of(
            TextureFactory.builder().addIcon(OVERLAY_FUSION2).extFacing().build(),
            TextureFactory.builder().addIcon(OVERLAY_FUSION2_GLOW).extFacing().glow().build());

    public LargeFusionComputer2(int id, String name, String nameRegional) {
        super(id,name,nameRegional);
    }

    public LargeFusionComputer2(String name) {
        super(name);
    }

    @Override
    public String[] getDescription() {
        final GT_Multiblock_Tooltip_Builder tt = new GT_Multiblock_Tooltip_Builder();
        tt.addMachineType("Fusion Reactor")
                .addInfo("Millions of nuclear.")
                .addInfo("Controller block for the Compact Fusion Reactor MK-II.")
                .addInfo("1048576EU/t and 10M EU capacity per Energy Hatch")
                .addInfo("If the recipe has a startup cost greater than the")
                .addInfo("number of energy hatches * cap, you can't do it")
                .addInfo("Make sure the whole structure is built in the 3x3")
                .addInfo("chuck area of the ring center (not controller).")
                .addInfo("It can run 256x recipes at most.")
                .addInfo("Support" + EnumChatFormatting.BLUE + " Tec" + EnumChatFormatting.DARK_BLUE + "Tech" + EnumChatFormatting.GRAY + " Energy/Laser Hatches!")
                .addInfo("The structure is too complex!")
                .addInfo(BLUE_PRINT_INFO)
                .addSeparator()
                .addEnergyHatch("1-32, Hint block with dot 3", 3)
                .addInputHatch("2-16, Hint block with dot 1", 1)
                .addOutputHatch("1-16, Hint block with dot 2", 2)
                .addStructureInfo("ALL Hatches must be ZPM or better")
                .toolTipFinisher("Good Generator");
        if (!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            return tt.getInformation();
        } else {
            return tt.getStructureInformation();
        }
    }

    @Override
    public long maxEUStore() {
        return 320006000L * (Math.min(32, this.mEnergyHatches.size() + this.eEnergyMulti.size())) / 32L;
    }

    @Override
    public Block getCasingBlock() {
        return GregTech_API.sBlockCasings4;
    }

    @Override
    public int getCasingMeta() {
        return 6;
    }

    @Override
    public Block getCoilBlock() {
        return Loaders.compactFusionCoil;
    }

    @Override
    public int getCoilMeta() {
        return 1;
    }

    @Override
    public Block getGlassBlock() {
        return ItemRegistry.bw_realglas;
    }

    @Override
    public int getGlassMeta() {
        return 4;
    }

    @Override
    public int hatchTier() {
        return 7;
    }

    @Override
    public Materials getFrameBox() {
        return Materials.Duranium;
    }

    @Override
    public ITexture getTextureOverlay() {
        return textureOverlay;
    }

    @Override
    public int tierOverclock() {
        return 2;
    }

    @Override
    public String[] getStructureDescription(ItemStack stackSize) {
        return DescTextLocalization.addText("LargeFusion.hint", 3);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new LargeFusionComputer2(mName);
    }
}
