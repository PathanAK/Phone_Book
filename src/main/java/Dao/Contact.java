package Dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CONTACT_DETAILS")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contactId;
    @NonNull
    private String contactName;
    private String contactEmail;
    private Long contactNum;


}
