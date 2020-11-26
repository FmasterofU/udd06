package org.elasticsearch.index.analysis.filter;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

/**
 *
 * @author Marko Martonosi (update to es7.4)
 */
public class LatCyrFilterFactory extends AbstractTokenFilterFactory {

    public LatCyrFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new LatCyrFilter(tokenStream);
    }
}
