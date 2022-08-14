package bootcamp.five.agency.newys.services.article;

import static org.assertj.core.api.Assertions.assertThat;

import bootcamp.five.agency.newys.dto.response.ArticleResponseDto;
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

    ArticleResponseDto articleResponseDto = updateArticleService.updateArticle(id, title, description, imageUrl, content);

    assertThat(articleResponseDto.getId().equals(id));
    assertThat(articleResponseDto.getTitle().equals(title));
    assertThat(articleResponseDto.getDescription().equals(description));
    assertThat(articleResponseDto.getImageUrl().equals(imageUrl));
    assertThat(articleResponseDto.getContent().equals(content));
  }

  @Test
  public void changeArticleAuthor_ArticleAuthorChanged_True() {
    final Long id = 1L;
    final Long authorId = 2L;

    ArticleResponseDto articleResponseDto = updateArticleService.changeArticleAuthor(id, authorId);

    assertThat(articleResponseDto.getAuthorId().equals(authorId));
  }

  @Test
  public void likeArticle_ArticleLiked_True() {
    final Long id = 1L;

    ArticleResponseDto articleResponseDto = getArticleService.getArticleById(id);

    ArticleResponseDto likedArticleResponseDto = updateArticleService.likeArticle(id);

    assertThat(articleResponseDto.getNumLikes() < likedArticleResponseDto.getNumLikes());
  }

  @Test
  public void unlikeArticle_ArticleUnlike_True() {
    final Long id = 1L;

    ArticleResponseDto articleResponseDto = getArticleService.getArticleById(id);

    ArticleResponseDto unlikedArticleResponseDto = updateArticleService.unlikeArticle(id);

    assertThat(articleResponseDto.getNumLikes() < unlikedArticleResponseDto.getNumLikes());
  }

}
