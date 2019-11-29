# udd06
Upravljanje digitalnim dokumentima Elasticsearch Analyzer / Digital documents management Elasticsearch Analyzer

### DESCRIPTION:  
SerbianAnalyzerElasticSearchPlugin is used for analyzing and preparing input text for indexing. 
> This plugin is written for **Java 13.0.1**, **Gradle 6.0** and **Elasticsearch 7.4.0**.
### TEXT PROCESS FLOW:
It uses StandardTokenizer for creating tokens out of input text. After tokenizer tokens go trough five filters:

    1. LowerCaseFilter - filter transforms all characters from token to lowercase.
    2. LatCyrFilter - takes lowercase words, and turns them from cyrilic to latinic.
    3. StopFilter - removes the stop words/tokens.
    4. SnowballFilter - stems tokens, taking only root of the word.
    5. RemoveAccentsFilter - replaces 'Dj' to 'D'.
    
### HOW TO BUILD PLUGIN
To build SerbianAnalyzer you will need Gradle. Position yourself in the root of the project and execute 

    ./gradlew clean build
This will create distribution archive file located in `build/distributions/` named `serbian-analyzer-1.0-SNAPSHOT.zip`.

### HOW TO SETUP PLUGIN TO WORK WITH ELASTICSEARCH
1. Position yourself inside `/bin` directory of the elasticsearch root and execute
    
        ./elasticsearch-plugin install file:<absolute path of distribution archive>
2. Run elasticsearch server
3. Issue an `mapping` query on elasticsearch server:

        curl -H 'Content-Type: application/json' -X PUT -D '{"mappings":{"properties":{"content":{"type":"text","fields":{"sr":{"type":"text","analyzer":"serbian"},"en":{"type":"text","analyzer":"english"}}}}}}' http://localhost:9200/tweet
Afterwards, on creation of new `tweet` document, content field will be analyzed by default analyzer for english and custom serbian, which was installed as a plugin. 
### HOW TO REMOVE PLUGIN
Position yourself inside `/bin` directory of the elasticsearch root and execute

    ./elasticsearch-plugin remove serbian-analyzer
