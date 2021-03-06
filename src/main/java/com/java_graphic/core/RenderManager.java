package com.java_graphic.core;

import com.java_graphic.core.entity.Model;
import com.java_graphic.core.utils.Utils;
import com.java_graphic.test.Launcher;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class RenderManager {
    private final WindowManager window;
    private ShaderManager shader;

    public RenderManager(){
        window = Launcher.getWindow();

    }

    public void init() throws Exception{
        shader = new ShaderManager();
        shader.createVertexShader(Utils.loadResource("../../resources/shaders/vertex.vs"));//! null pointer exception
        shader.createFragmentShader(Utils.loadResource("../../resources/shaders/fragment.fs"));
        shader.link();


    }
    public void render(Model model){
        clear();
        shader.bind();
        GL30.glBindVertexArray(model.getId());
        GL20.glEnableVertexAttribArray(0);
        GL11.glDrawArrays(GL11.GL_TRIANGLES,0,model.getVertexCount());
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
        shader.unbind();
    }
    public void clear(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    }

    public void cleanUp(){
        shader.cleanUp();
    }
}
