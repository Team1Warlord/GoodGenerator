package goodgenerator.blocks.regularBlock;

import com.github.bartimaeusnek.bartworks.common.blocks.BW_GlasBlocks;
import goodgenerator.main.GoodGenerator;

public class GGGlass extends BW_GlasBlocks {

    public GGGlass(String name, String[] texture, short[][] color) {
        super(name, texture, color, GoodGenerator.GG, true, false);
    }

}
