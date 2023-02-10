
package org.scijava.modelrunner.engine;

import io.bioimage.modelrunner.engine.EngineInfo;

import org.scijava.plugin.RichPlugin;

public interface DLModelRunnerPlugin extends RichPlugin {

	public EngineInfo createEngineInfo();
}
