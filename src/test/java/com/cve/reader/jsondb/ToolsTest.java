package com.cve.reader.jsondb;

import com.cve.reader.jsondb.pojo.MockObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

class ToolsTest {

    ObjectMapper objectMapper = Helper.OBJECT_MAPPER;
    JsonProcessor jsonProcessor;

    @Test
    public void shouldSerialize_WithPublicFields_AndNullValues() throws JsonProcessingException {
        MockObject publicPerson = new MockObject(null, 21);

        String json = objectMapper.writeValueAsString(publicPerson);

        assertThat(json).isEqualTo("{\"name\":null,\"age\":21}");
    }
//
//    @Test
//    void deserializeJsonFileAssertNotNull() throws IOException {
//        jsonProcessor.jsonExtractor(
//                jsonEvent());
//    }

//    @Test
//    public void fgf() {
//        jsonProcessor.getCveObjects()
//    }

    @Test public void testMoneyStringIllegalValue() {
        try {
            new JsonProcessor(null);
            fail("Exception was expected for null input");
        } catch (IllegalArgumentException | IOException e) {

        }
    }

    private String jsonEvent() {
        return "String json = \"{\\n\" +\n" +
                "            \"  \\\"CVE_data_type\\\": \\\"CVE\\\",\\n\" +\n" +
                "            \"  \\\"CVE_data_format\\\": \\\"MITRE\\\",\\n\" +\n" +
                "            \"  \\\"CVE_data_version\\\": \\\"4.0\\\",\\n\" +\n" +
                "            \"  \\\"CVE_data_numberOfCVEs\\\": \\\"1173\\\",\\n\" +\n" +
                "            \"  \\\"CVE_data_timestamp\\\": \\\"2020-04-22T10:00Z\\\",\\n\" +\n" +
                "            \"  \\\"CVE_Items\\\": [\\n\" +\n" +
                "            \"    {\\n\" +\n" +
                "            \"      \\\"cve\\\": {\\n\" +\n" +
                "            \"        \\\"data_type\\\": \\\"CVE\\\",\\n\" +\n" +
                "            \"        \\\"data_format\\\": \\\"MITRE\\\",\\n\" +\n" +
                "            \"        \\\"data_version\\\": \\\"4.0\\\",\\n\" +\n" +
                "            \"        \\\"CVE_data_meta\\\": {\\n\" +\n" +
                "            \"          \\\"ID\\\": \\\"CVE-2011-3015\\\",\\n\" +\n" +
                "            \"          \\\"ASSIGNER\\\": \\\"cve@mitre.org\\\"\\n\" +\n" +
                "            \"        },\\n\" +\n" +
                "            \"        \\\"problemtype\\\": {\\n\" +\n" +
                "            \"          \\\"problemtype_data\\\": [\\n\" +\n" +
                "            \"            {\\n\" +\n" +
                "            \"              \\\"description\\\": [\\n\" +\n" +
                "            \"                {\\n\" +\n" +
                "            \"                  \\\"lang\\\": \\\"en\\\",\\n\" +\n" +
                "            \"                  \\\"value\\\": \\\"CWE-190\\\"\\n\" +\n" +
                "            \"                }\\n\" +\n" +
                "            \"              ]\\n\" +\n" +
                "            \"            }\\n\" +\n" +
                "            \"          ]\\n\" +\n" +
                "            \"        },\\n\" +\n" +
                "            \"        \\\"references\\\": {\\n\" +\n" +
                "            \"          \\\"reference_data\\\": [\\n\" +\n" +
                "            \"            {\\n\" +\n" +
                "            \"              \\\"url\\\": \\\"http://code.google.com/p/chromium/issues/detail?id=105803\\\",\\n\" +\n" +
                "            \"              \\\"name\\\": \\\"http://code.google.com/p/chromium/issues/detail?id=105803\\\",\\n\" +\n" +
                "            \"              \\\"refsource\\\": \\\"CONFIRM\\\",\\n\" +\n" +
                "            \"              \\\"tags\\\": [\\n\" +\n" +
                "            \"                \\\"Issue Tracking\\\",\\n\" +\n" +
                "            \"                \\\"Patch\\\",\\n\" +\n" +
                "            \"                \\\"Vendor Advisory\\\"\\n\" +\n" +
                "            \"              ]\\n\" +\n" +
                "            \"            },\\n\" +\n" +
                "            \"            {\\n\" +\n" +
                "            \"              \\\"url\\\": \\\"http://googlechromereleases.blogspot.com/2012/02/chrome-stable-update.html\\\",\\n\" +\n" +
                "            \"              \\\"name\\\": \\\"http://googlechromereleases.blogspot.com/2012/02/chrome-stable-update.html\\\",\\n\" +\n" +
                "            \"              \\\"refsource\\\": \\\"CONFIRM\\\",\\n\" +\n" +
                "            \"              \\\"tags\\\": [\\n\" +\n" +
                "            \"                \\\"Release Notes\\\",\\n\" +\n" +
                "            \"                \\\"Vendor Advisory\\\"\\n\" +\n" +
                "            \"              ]\\n\" +\n" +
                "            \"            },\\n\" +\n" +
                "            \"            {\\n\" +\n" +
                "            \"              \\\"url\\\": \\\"http://secunia.com/advisories/48016\\\",\\n\" +\n" +
                "            \"              \\\"name\\\": \\\"48016\\\",\\n\" +\n" +
                "            \"              \\\"refsource\\\": \\\"SECUNIA\\\",\\n\" +\n" +
                "            \"              \\\"tags\\\": [\\n\" +\n" +
                "            \"                \\\"Not Applicable\\\"\\n\" +\n" +
                "            \"              ]\\n\" +\n" +
                "            \"            },\\n\" +\n" +
                "            \"            {\\n\" +\n" +
                "            \"              \\\"url\\\": \\\"https://oval.cisecurity.org/repository/search/definition/oval%3Aorg.mitre.oval%3Adef%3A14690\\\",\\n\" +\n" +
                "            \"              \\\"name\\\": \\\"oval:org.mitre.oval:def:14690\\\",\\n\" +\n" +
                "            \"              \\\"refsource\\\": \\\"OVAL\\\",\\n\" +\n" +
                "            \"              \\\"tags\\\": [\\n\" +\n" +
                "            \"                \\\"Third Party Advisory\\\"\\n\" +\n" +
                "            \"              ]\\n\" +\n" +
                "            \"            }\\n\" +\n" +
                "            \"          ]\\n\" +\n" +
                "            \"        },\\n\" +\n" +
                "            \"        \\\"description\\\": {\\n\" +\n" +
                "            \"          \\\"description_data\\\": [\\n\" +\n" +
                "            \"            {\\n\" +\n" +
                "            \"              \\\"lang\\\": \\\"en\\\",\\n\" +\n" +
                "            \"              \\\"value\\\": \\\"Multiple integer overflows in the PDF codecs in Google Chrome before 17.0.963.56 allow remote attackers to cause a denial of service or possibly have unspecified other impact via unknown vectors.\\\"\\n\" +\n" +
                "            \"            }\\n\" +\n" +
                "            \"          ]\\n\" +\n" +
                "            \"        }\\n\" +\n" +
                "            \"      },\\n\" +\n" +
                "            \"      \\\"configurations\\\": {\\n\" +\n" +
                "            \"        \\\"CVE_data_version\\\": \\\"4.0\\\",\\n\" +\n" +
                "            \"        \\\"nodes\\\": [\\n\" +\n" +
                "            \"          {\\n\" +\n" +
                "            \"            \\\"operator\\\": \\\"OR\\\",\\n\" +\n" +
                "            \"            \\\"cpe_match\\\": [\\n\" +\n" +
                "            \"              {\\n\" +\n" +
                "            \"                \\\"vulnerable\\\": true,\\n\" +\n" +
                "            \"                \\\"cpe23Uri\\\": \\\"cpe:2.3:a:google:chrome:*:*:*:*:*:*:*:*\\\",\\n\" +\n" +
                "            \"                \\\"versionEndExcluding\\\": \\\"17.0.963.56\\\"\\n\" +\n" +
                "            \"              }\\n\" +\n" +
                "            \"            ]\\n\" +\n" +
                "            \"          }\\n\" +\n" +
                "            \"        ]\\n\" +\n" +
                "            \"      },\\n\" +\n" +
                "            \"      \\\"impact\\\": {\\n\" +\n" +
                "            \"        \\\"baseMetricV2\\\": {\\n\" +\n" +
                "            \"          \\\"cvssV2\\\": {\\n\" +\n" +
                "            \"            \\\"version\\\": \\\"2.0\\\",\\n\" +\n" +
                "            \"            \\\"vectorString\\\": \\\"AV:N/AC:M/Au:N/C:P/I:P/A:P\\\",\\n\" +\n" +
                "            \"            \\\"accessVector\\\": \\\"NETWORK\\\",\\n\" +\n" +
                "            \"            \\\"accessComplexity\\\": \\\"MEDIUM\\\",\\n\" +\n" +
                "            \"            \\\"authentication\\\": \\\"NONE\\\",\\n\" +\n" +
                "            \"            \\\"confidentialityImpact\\\": \\\"PARTIAL\\\",\\n\" +\n" +
                "            \"            \\\"integrityImpact\\\": \\\"PARTIAL\\\",\\n\" +\n" +
                "            \"            \\\"availabilityImpact\\\": \\\"PARTIAL\\\",\\n\" +\n" +
                "            \"            \\\"baseScore\\\": 6.8\\n\" +\n" +
                "            \"          },\\n\" +\n" +
                "            \"          \\\"severity\\\": \\\"MEDIUM\\\",\\n\" +\n" +
                "            \"          \\\"exploitabilityScore\\\": 8.6,\\n\" +\n" +
                "            \"          \\\"impactScore\\\": 6.4,\\n\" +\n" +
                "            \"          \\\"acInsufInfo\\\": false,\\n\" +\n" +
                "            \"          \\\"obtainAllPrivilege\\\": false,\\n\" +\n" +
                "            \"          \\\"obtainUserPrivilege\\\": false,\\n\" +\n" +
                "            \"          \\\"obtainOtherPrivilege\\\": false,\\n\" +\n" +
                "            \"          \\\"userInteractionRequired\\\": true\\n\" +\n" +
                "            \"        }\\n\" +\n" +
                "            \"      },\\n\" +\n" +
                "            \"      \\\"publishedDate\\\": \\\"2012-02-16T20:55Z\\\",\\n\" +\n" +
                "            \"      \\\"lastModifiedDate\\\": \\\"2020-04-16T17:30Z\\\"\\n\" +\n" +
                "            \"    }\\n\" +\n" +
                "            \"  ]\\n\" +\n" +
                "            \"}\";";
    }

}