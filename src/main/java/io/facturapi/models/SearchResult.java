package io.facturapi.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult<T> {
  private Integer page;
  private Integer totalPages;
  @JsonAlias({"total"})
  private Integer totalResults;
  private Boolean totalsAreCapped;
  private Boolean hasMore;
  private String nextCursor;
  private String previousCursor;
  private List<T> data = new ArrayList<>();

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public Integer getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(Integer totalResults) {
    this.totalResults = totalResults;
  }

  public Boolean getTotalsAreCapped() {
    return totalsAreCapped;
  }

  public void setTotalsAreCapped(Boolean totalsAreCapped) {
    this.totalsAreCapped = totalsAreCapped;
  }

  public Boolean getHasMore() {
    return hasMore;
  }

  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }

  public String getNextCursor() {
    return nextCursor;
  }

  public void setNextCursor(String nextCursor) {
    this.nextCursor = nextCursor;
  }

  public String getPreviousCursor() {
    return previousCursor;
  }

  public void setPreviousCursor(String previousCursor) {
    this.previousCursor = previousCursor;
  }

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }
}
