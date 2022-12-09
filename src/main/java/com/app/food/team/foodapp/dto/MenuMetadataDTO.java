package com.app.food.team.foodapp.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Persister;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

//attempting to use this DTO to return results of repo SQL/JPQL query of specific fields
public class MenuMetadataDTO {
//    @Value("#{target.internal_id}")
//    int getInternalId();
//    @Value("#{target.title}")
//    String getTitle();
//    LocalDateTime getCreatedDateTime();
//    LocalDateTime getEditedDateTime();
//    LocalDateTime getStartDateTime();
//    LocalDateTime getEndDateTime();



    private @Getter @Setter int internalId;
    private @Getter @Setter String title;
    private @Getter @Setter LocalDateTime createdDateTime;
    private @Getter @Setter LocalDateTime editedDateTime;
//    protected @Getter @Setter LocalDateTime startDateTime;
//    protected @Getter @Setter LocalDateTime endDateTime;

    public MenuMetadataDTO(int internalId, String title, LocalDateTime createdDateTime, LocalDateTime editedDateTime) {
        this.internalId = internalId;
        this.title = title;
        this.createdDateTime = createdDateTime;
        this.editedDateTime = editedDateTime;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuMetadataDTO that = (MenuMetadataDTO) o;

        if (getInternalId() != that.getInternalId()) return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        if (getCreatedDateTime() != null ? !getCreatedDateTime().equals(that.getCreatedDateTime()) : that.getCreatedDateTime() != null)
            return false;
        return getEditedDateTime() != null ? getEditedDateTime().equals(that.getEditedDateTime()) : that.getEditedDateTime() == null;
    }

    @Override
    public int hashCode() {
        int result = getInternalId();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getCreatedDateTime() != null ? getCreatedDateTime().hashCode() : 0);
        result = 31 * result + (getEditedDateTime() != null ? getEditedDateTime().hashCode() : 0);
        return result;
    }
}
