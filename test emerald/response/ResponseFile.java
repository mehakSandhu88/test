package com.rbc.ipdEmerald.stub.response;

import

@XmlRootElement (name = "file") 
@NoArgsConstructor
@Setter

public class ResponseFile implements Serializable {
    @XmlElement(name = "file_name")
    String file_name;

    @XmlElement(name = "file_type")
    String file_type;

    @XMLElement(name="file_reference_number")
    String file_reference_number;

    public ResponseFile(String file_name, String file_type, String file_reference_number) { 
        super();
        this.file_name = file_name;
        this.file_type = "4";
        this.file_reference_number = file_reference_number;
    }

}

