package bootcamp.five.agency.newys.services.article;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.article.GetArticleDetailsResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateArticleServiceTest {

  @Autowired
  private UpdateArticleService updateArticleService;
  @Autowired
  private GetArticleService getArticleService;

  @Test
  public void updateArticle_ArticleUpdated_True() {
    final Long id = 1L;
    final String title = "New Samsung announced";
    final String description = "New Samsung announced";
    final String imageUrl = "images/samsung.png";
    final String content = "New Samsung announced";

    GetArticleDetailsResponseDto getArticleDetailsResponseDto = updateArticleService.updateArticle(id, title, description, imageUrl, content);

    assertThat(getArticleDetailsResponseDto.getId().equals(id));
    assertThat(getArticleDetailsResponseDto.getTitle().equals(title));
    assertThat(getArticleDetailsResponseDto.getDescription().equals(description));
    assertThat(getArticleDetailsResponseDto.getImageUrl().equals(imageUrl));
    assertThat(getArticleDetailsResponseDto.getContent().equals(content));
  }

  @Test
  public void changeArticleAuthor_ArticleAuthorChanged_True() {
    final Long id = 1L;
    final Long authorId = 2L;

    GetArticleDetailsResponseDto getArticleDetailsResponseDto = updateArticleService.changeArticleAuthor(id, authorId);

    assertThat(getArticleDetailsResponseDto.getAuthorId().equals(authorId));
  }

  @Test
  public void likeArticle_ArticleLiked_True() {
    final Long id = 1L;

    GetArticleDetailsResponseDto getArticleDetailsResponseDto = getArticleService.getArticleById(id);

    GetArticleDetailsResponseDto likedGetArticleDetailsResponseDto = updateArticleService.likeArticle(id);

    assertThat(getArticleDetailsResponseDto.getNumLikes() < likedGetArticleDetailsResponseDto.getNumLikes());
  }

  @Test
  public void unlikeArticle_ArticleUnlike_True() {
    final Long id = 1L;

    GetArticleDetailsResponseDto getArticleDetailsResponseDto = getArticleService.getArticleById(id);

    GetArticleDetailsResponseDto unlikedGetArticleDetailsResponseDto = updateArticleService.unlikeArticle(id);

    assertThat(getArticleDetailsResponseDto.getNumLikes() > unlikedGetArticleDetailsResponseDto.getNumLikes());
  }

}
