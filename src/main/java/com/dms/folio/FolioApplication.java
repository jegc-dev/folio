package com.dms.folio;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.odf.OpenDocumentParser;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class FolioApplication {

    public static void main(String[] args) throws Exception, SolrServerException, IOException
    {

        SpringApplication.run(FolioApplication.class, args);

        /*final String serverBaseUrl = "http://localhost:8983/solr/mycol1";

        Http2SolrClient solr = new Http2SolrClient
                .Builder(serverBaseUrl)
                .build();

        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", "123456");
        document.addField("name", "Kenmore Dishwasher");
        document.addField("price", "599.99");
        solr.add(document);
        solr.commit();

        SolrQuery query = new SolrQuery();
        query.set("q", "price:599.99");
        QueryResponse response = solr.query(query);

        SolrDocumentList docList = response.getResults();
        //assertEquals(docList.getNumFound(), 1);

        for (SolrDocument doc : docList) {
            System.out.println("id = " + doc.getFieldValue("id"));
            System.out.println("price = " + doc.getFieldValue("price"));

        }*/

        /**
         * Extract content
         */

        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        FileInputStream inputStream = new FileInputStream(new File(
                "/home/goguen/tika/Jorge_Granados-Senior-Software-Developer_lastUpdate_20221031.docx"));

        ParseContext parseContext = new ParseContext();

        //parsing the document using PDF parser
        //PDFParser pdfparser = new PDFParser();
        //pdfparser.parse(inputStream, handler, metadata,parseContext);

        //Open Document Parser
        OpenDocumentParser openofficeparser = new OpenDocumentParser ();
        openofficeparser.parse(inputStream, handler, metadata,parseContext);


        //getting the content of the document
        System.out.println("Contents of the PDF :" + handler.toString());

        //getting metadata of the document
        System.out.println("Metadata of the PDF:");
        String[] metadataNames = metadata.names();

        for(String name : metadataNames) {
            System.out.println(name+ " : " + metadata.get(name));
        }

    }

}
