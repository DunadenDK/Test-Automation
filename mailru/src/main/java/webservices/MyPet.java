package webservices;

import java.util.Arrays;

public class MyPet {

  private Long id;
  private String name;
  private String[] photoUrls;
  private String[] tags;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String[] getPhotoUrls() {
    return photoUrls;
  }

  public void setPhotoUrls(String[] photoUrls) {
    this.photoUrls = photoUrls;
  }

  public String[] getTags() {
    return tags;
  }

  public void setTags(String[] tags) {
    this.tags = tags;
  }

  @Override
  public String toString() {
    return "MyPet{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", photoUrls="
        + Arrays.toString(photoUrls)
        + ", tags="
        + Arrays.toString(tags)
        + '}';
  }
}
