package net.bettermc.expanse.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.bettermc.expanse.ExpanseMain;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ElectricFurnaceScreen extends HandledScreen<ElectricFurnaceScreenHandler> {
    private static final Identifier TEXTURE =
        new Identifier(ExpanseMain.MOD_ID, "textures/gui/electricfurnace_gui.png");

    public ElectricFurnaceScreen(ElectricFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        this.titleX = (this.backgroundWidth - this.textRenderer.getWidth(this.title)) / 2;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (this.width - this.backgroundWidth) / 2;
        int y = (this.height - this.backgroundHeight) / 2;
        this.drawTexture(matrices, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);

        if (this.handler.isCrafting()) {
            this.drawTexture(matrices, x + 84, y + 22, 176, 14, this.handler.getScaledProgress(), 36);
        }

        if (this.handler.hasFuel()) {
            this.drawTexture(matrices, x + 18, y + 33 + 14 - this.handler.getScaledFuelProgress(), 176,
                14 - this.handler.getScaledFuelProgress(), 14, this.handler.getScaledFuelProgress()
            );
        }
    }
}
