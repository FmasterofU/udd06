package org.elasticsearch.plugin.analysis;

import org.apache.lucene.analysis.Analyzer;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.SerbianAnalyzerProvider;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.filter.LatCyrFilterFactory;
import org.elasticsearch.index.analysis.filter.RemoveAccentsFilterFactory;
import org.elasticsearch.index.analysis.stemmer.SerbianStemTokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;
import java.util.Map;
import java.util.HashMap;

import static java.util.Collections.singletonMap;
/**
 *
 * @author Milan Deket
 * @author Marko Martonosi (update to es7.4)
 */
public class AnalysisSerbianPlugin extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        Map<String, AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
        extra.put("serbian_accents_filter", RemoveAccentsFilterFactory::new);
        extra.put("serbian_lat_cyr_filter", LatCyrFilterFactory::new);
        extra.put("serbian_stemmer", SerbianStemTokenFilterFactory::new);
        return extra;
    }

    @Override
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return singletonMap("serbian", SerbianAnalyzerProvider::new);
    }
}
