package in.reqres.models.lists;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ListUsersResponseModel {
    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    private List<ListUsersDataResponseModel> data;
    private ListUsersSupportResponseModel support;
}
