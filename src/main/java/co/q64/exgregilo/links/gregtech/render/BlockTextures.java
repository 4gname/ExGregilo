package co.q64.exgregilo.links.gregtech.render;

import co.q64.exgregilo.data.ModData;
import gregtech.api.GregTech_API;
import gregtech.api.interfaces.IIconContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

public enum BlockTextures implements IIconContainer, Runnable {
	//formatter:off
	BLANK("BLANK"),
	OVERLAY_AUTO_SIEVE_TOP("OVERLAY_AUTO_SIEVE_TOP"),
	OVERLAY_AUTO_SIEVE_FRONT("OVERLAY_AUTO_SIEVE_FRONT"),
	OVERLAY_AUTO_SIEVE_BASIC_TOP("OVERLAY_AUTO_SIEVE_BASIC_TOP");
	//formatter:on
	;

	private String textureName;
	private IIcon icon;

	private BlockTextures(String textureName) {
		this.textureName = textureName;
		GregTech_API.sGTBlockIconload.add(this);
	}

	@Override
	public void run() {
		icon = GregTech_API.sBlockIcons.registerIcon(ModData.BLOCK_ICON_TEX_PATH + textureName);
	}

	@Override
	public IIcon getIcon() {
		return icon;
	}

	@Override
	public IIcon getOverlayIcon() {
		return null;
	}

	@Override
	public ResourceLocation getTextureFile() {
		return TextureMap.locationBlocksTexture;
	}
}
