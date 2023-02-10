package org.scijava.modelrunner;

import java.util.List;

import org.scijava.modelrunner.engine.DLModelRunnerPlugin;
import org.scijava.service.SciJavaService;

public interface ModelRunnerService extends SciJavaService {

	public List<DLModelRunnerPlugin> getEngines();
}
