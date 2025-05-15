package com.rbc.ipdEmerald.stub.model;

import

@XmlRootElement(name = "file") 
@NoArgsConstructor
@getter

public class File {

@XmlElement(name = "file_name")
String file_name;

@XmlElement(name = "file_type")
String file_type;

@XmlElement (name="file_reference_number")
String file_reference_number;


public File(String file_name, String file_type, String file_reference_number) {
    super();
this.file_name = file_name;
this.file_type = file_type;
this.file_reference_number = file_reference_number;
}

}
