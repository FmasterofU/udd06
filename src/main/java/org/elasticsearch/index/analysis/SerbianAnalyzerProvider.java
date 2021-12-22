package org.elasticsearch.index.analysis;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;

/**
 *
 * @author Milan Deket
 * @author Marko Martonosi (update to es7.4)
 */
public class SerbianAnalyzerProvider extends AbstractIndexAnalyzerProvider<SerbianAnalyzer> {

    private final SerbianAnalyzer analyzer;

    public SerbianAnalyzerProvider(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);
        analyzer = new SerbianAnalyzer();
        // TODO: fin a solution for version to be inported
        // analyzer.setVersion(version);
    }

    @Override
    public SerbianAnalyzer get() {
        return this.analyzer;
    }
}
