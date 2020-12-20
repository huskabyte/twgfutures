package timberwolfgalaxy.futures.objects.entities.abstracts;

import java.util.function.Function;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public abstract class SegmentedModel<E extends Entity> extends ModelBase{
  public SegmentedModel() {
	  
  }
  
  public void render(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
    getParts().forEach(p_228272_8_ -> p_228272_8_.render(p_228272_0_, p_228272_1_, p_228272_2_, p_228272_3_, p_228272_4_, p_228272_5_, p_228272_6_, p_228272_7_));
  }
  
  public abstract Iterable<ModelRenderer> getParts();
}
