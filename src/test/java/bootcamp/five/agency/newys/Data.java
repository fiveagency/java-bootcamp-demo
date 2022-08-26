package bootcamp.five.agency.newys;

import bootcamp.five.agency.newys.domain.Article;
import bootcamp.five.agency.newys.domain.Author;
import bootcamp.five.agency.newys.domain.Category;
import bootcamp.five.agency.newys.dto.request.author.CreateAuthorRequestDto;
import bootcamp.five.agency.newys.dto.request.author.UpdateAuthorRequestDto;
import bootcamp.five.agency.newys.dto.response.article.*;
import bootcamp.five.agency.newys.dto.response.author.AuthorDetailsResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetAuthorCategoriesResponseDto;
import bootcamp.five.agency.newys.dto.response.category.GetCategoryDetailsResponseDto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {

    public static final Long articleId = 1L;
    public static final String articleTitle = "New iPhone announced";
    public static final String articleDescription = "New iPhone announced";
    public static final String articleImageUrl = "images/iphone.png";
    public static final String articleContent = "New iPhone announced";
    public static final Date articleDateOfPublicationNow = Date.valueOf(LocalDate.now());
    public static final Date articleDateOfPublication3DaysAgo = Date.valueOf(LocalDate.now().minusDays(3));
    public static final Date articleDateOfPublication5DaysAgo = Date.valueOf(LocalDate.now().minusDays(5));
    public static final int articleNumLikes0 = 0;
    public static final int articleNumLikes8 = 8;
    public static final int articleNumLikes9 = 9;

    public static final Long articleId2 = 2L;
    public static final String articleTitle2 = "New Samsung phone announced";
    public static final String articleDescription2 = "New Samsung phone announced";
    public static final String articleImageUrl2 = "images/samsung.png";
    public static final String articleContent2 = "New Samsung phone announced";

    public static final Long authorId = 1L;
    public static final String authorFirstName = "Marko";
    public static final String authorLastName = "Markich";
    public static final String authorEmail = "marko.markich@mail.com";
    public static final String authorType = "Sport";

    public static final Long authorId2 = 2L;
    public static final String authorFirstName2 = "Rocky";
    public static final String authorLastName2 = "Balboa";
    public static final String authorEmail2 = "rocky.balboa@mail.com";
    public static final String authorType2 = "Sport";

    public static final Long categoryId = 1L;
    public static final String categoryName = "Sports";
    public static final String categoryDescription = "Sports category";

    public static final Long categoryId2 = 2L;
    public static final String categoryName2 = "Tech";
    public static final String categoryDescription2 = "Tech category";

    public static final Author author = new Author.AuthorBuilder()
            .id(authorId)
            .firstName(authorFirstName)
            .lastName(authorLastName)
            .email(authorEmail)
            .type(authorType)
            .articles(new ArrayList<>())
            .categories(new ArrayList<>())
            .build();
    public static final Author author2 = new Author.AuthorBuilder()
            .id(authorId2)
            .firstName(authorFirstName2)
            .lastName(authorLastName2)
            .email(authorEmail2)
            .type(authorType2)
            .build();
    public static final Author authorNoArticles = new Author.AuthorBuilder()
            .id(authorId)
            .firstName(authorFirstName)
            .lastName(authorLastName)
            .email(authorEmail)
            .articles(new ArrayList<Article>())
            .build();
    public static final Author authorUpdated = new Author.AuthorBuilder()
            .id(authorId)
            .firstName(authorFirstName2)
            .lastName(authorLastName2)
            .email(authorEmail2)
            .type(authorType2)
            .articles(new ArrayList<>())
            .categories(new ArrayList<>())
            .build();

    public static final List<Author> authorsOfSameType = List.of(author, author2);
    public static final List<Author> authorsAll = List.of(author, author2);

    public static final Category category = new Category.CategoryBuilder()
            .id(categoryId)
            .name(categoryName)
            .description(categoryDescription)
            .author(author)
            .addedArticles(new ArrayList<>())
            .build();
    public static final Category category2 = new Category.CategoryBuilder()
            .id(categoryId2)
            .name(categoryName2)
            .description(categoryDescription2)
            .author(author)
            .addedArticles(new ArrayList<>())
            .build();
    public static final Category categoryUpdated = new Category.CategoryBuilder()
            .id(categoryId)
            .name(categoryName2)
            .description(categoryDescription2)
            .author(author)
            .addedArticles(new ArrayList<>())
            .build();
    public static final Category categoryAuthorChanged = new Category.CategoryBuilder()
            .id(categoryId)
            .name(categoryName)
            .description(categoryDescription)
            .author(author2)
            .addedArticles(new ArrayList<>())
            .build();

    public static final List<Category> categoriesByAuthor = List.of(category, category2);
    public static final List<Category> categoriesAll = List.of(category, category2);
    public static final List<Category> singleCategory = List.of(category);

    public static final Article article = new Article.ArticleBuilder()
            .id(articleId)
            .title(articleTitle)
            .imageUrl(articleImageUrl)
            .description(articleDescription)
            .content(articleContent)
            .dateOfPublication(articleDateOfPublicationNow)
            .numLikes(0)
            .author(author)
            .categories(new ArrayList<>())
            .build();
    public static final Article article2 = new Article.ArticleBuilder()
            .id(articleId2)
            .title(articleTitle2)
            .description(articleDescription2)
            .imageUrl(articleImageUrl2)
            .dateOfPublication(articleDateOfPublicationNow)
            .content(articleContent2)
            .numLikes(articleNumLikes0)
            .author(author)
            .categories(new ArrayList<>())
            .build();
    public static final Article articleFrom3Days = new Article.ArticleBuilder()
            .id(articleId)
            .title(articleTitle)
            .imageUrl(articleImageUrl)
            .description(articleDescription)
            .content(articleContent)
            .dateOfPublication(articleDateOfPublication3DaysAgo)
            .numLikes(0)
            .author(author)
            .build();
    public static final Article articleFrom5Days = new Article.ArticleBuilder()
            .id(articleId2)
            .title(articleTitle2)
            .description(articleDescription2)
            .imageUrl(articleImageUrl2)
            .dateOfPublication(articleDateOfPublication5DaysAgo)
            .content(articleContent2)
            .numLikes(articleNumLikes0)
            .author(author)
            .build();
    public static final Article article8Likes = new Article.ArticleBuilder()
            .id(articleId)
            .title(articleTitle)
            .imageUrl(articleImageUrl)
            .description(articleDescription)
            .content(articleContent)
            .dateOfPublication(articleDateOfPublicationNow)
            .numLikes(articleNumLikes8)
            .author(author)
            .build();
    public static final Article article9Likes = new Article.ArticleBuilder()
            .id(articleId2)
            .title(articleTitle2)
            .description(articleDescription2)
            .imageUrl(articleImageUrl2)
            .dateOfPublication(articleDateOfPublicationNow)
            .content(articleContent2)
            .numLikes(articleNumLikes9)
            .author(author)
            .build();
    public static final Article updatedArticle = new Article.ArticleBuilder()
            .id(articleId)
            .title(articleTitle2)
            .description(articleDescription2)
            .imageUrl(articleImageUrl2)
            .dateOfPublication(articleDateOfPublicationNow)
            .content(articleContent2)
            .numLikes(articleNumLikes0)
            .build();
    public static final Article updatedArticleAuthorChanged = new Article.ArticleBuilder()
            .id(articleId)
            .title(articleTitle)
            .description(articleDescription)
            .imageUrl(articleImageUrl)
            .dateOfPublication(articleDateOfPublicationNow)
            .content(articleContent)
            .numLikes(articleNumLikes0)
            .author(author2)
            .build();
    public static final Article articleWithCategory = new Article.ArticleBuilder()
            .id(articleId)
            .title(articleTitle)
            .description(articleDescription)
            .imageUrl(articleImageUrl)
            .dateOfPublication(articleDateOfPublicationNow)
            .content(articleContent)
            .numLikes(articleNumLikes0)
            .author(author)
            .categories(singleCategory)
            .build();
    public static final List<Article> articlesByAuthor = List.of(article, article2);
    public static final List<Article> latestArticles = List.of(articleFrom3Days, articleFrom5Days);
    public static final List<Article> popularArticles = List.of(article8Likes, article9Likes);
    public static final List<Article> allArticles = List.of(article, article2);

    public static final GetArticleDetailsResponseDto articleDetailsDto = new GetArticleDetailsResponseDto.GetArticleDetailsResponseDtoBuilder()
            .id(articleId)
            .title(articleTitle)
            .description(articleDescription)
            .imageUrl(articleImageUrl)
            .dateOfPublication(articleDateOfPublicationNow)
            .content(articleContent)
            .numLikes(articleNumLikes0)
            .authorId(authorId)
            .build();
    public static final GetArticleDetailsResponseDto articleDetailsDto2 = new GetArticleDetailsResponseDto.GetArticleDetailsResponseDtoBuilder()
            .id(articleId2)
            .title(articleTitle2)
            .description(articleDescription2)
            .imageUrl(articleImageUrl2)
            .dateOfPublication(articleDateOfPublicationNow)
            .content(articleContent2)
            .numLikes(articleNumLikes0)
            .authorId(authorId)
            .build();
    public static final GetArticleDetailsResponseDto updatedArticleDto = new GetArticleDetailsResponseDto.GetArticleDetailsResponseDtoBuilder()
            .id(articleId)
            .title(articleTitle2)
            .description(articleDescription2)
            .imageUrl(articleImageUrl2)
            .dateOfPublication(articleDateOfPublicationNow)
            .content(articleContent2)
            .numLikes(articleNumLikes0)
            .build();
    public static final GetArticleDetailsResponseDto updatedArticleAuthorChangedDto = new GetArticleDetailsResponseDto.GetArticleDetailsResponseDtoBuilder()
            .id(articleId)
            .title(articleTitle)
            .description(articleDescription)
            .imageUrl(articleImageUrl)
            .dateOfPublication(articleDateOfPublicationNow)
            .content(articleContent)
            .numLikes(articleNumLikes0)
            .authorId(authorId2)
            .build();
    public static final GetArticleDetailsResponseDto article8LikesDetailsDto = new GetArticleDetailsResponseDto.GetArticleDetailsResponseDtoBuilder()
            .id(articleId)
            .title(articleTitle)
            .description(articleDescription)
            .imageUrl(articleImageUrl)
            .dateOfPublication(articleDateOfPublicationNow)
            .content(articleContent)
            .numLikes(articleNumLikes8)
            .authorId(authorId)
            .build();
    public static final GetArticleDetailsResponseDto article9LikesDetailsDto = new GetArticleDetailsResponseDto.GetArticleDetailsResponseDtoBuilder()
            .id(articleId)
            .title(articleTitle)
            .description(articleDescription)
            .imageUrl(articleImageUrl)
            .dateOfPublication(articleDateOfPublicationNow)
            .content(articleContent)
            .numLikes(articleNumLikes9)
            .authorId(authorId)
            .build();
    public static final GetLatestArticlesResponseDto latestArticleDto = new GetLatestArticlesResponseDto.GetLatestArticlesResponseDtoBuilder()
            .id(articleId)
            .title(articleTitle)
            .description(articleDescription)
            .dateOfPublication(articleDateOfPublication3DaysAgo)
            .build();
    public static final GetLatestArticlesResponseDto latestArticleDto2 = new GetLatestArticlesResponseDto.GetLatestArticlesResponseDtoBuilder()
            .id(articleId2)
            .title(articleTitle2)
            .description(articleDescription2)
            .dateOfPublication(articleDateOfPublication5DaysAgo)
            .build();

    public static final GetAuthorArticlesResponseDto authorArticleDto = new GetAuthorArticlesResponseDto.GetAuthorArticlesResponseDtoBuilder()
            .id(articleId)
            .title(articleTitle)
            .description(articleDescription)
            .authorId(authorId)
            .authorFirstName(authorFirstName)
            .authorLastName(authorLastName)
            .build();
    public static final GetAuthorArticlesResponseDto authorArticleDto2 = new GetAuthorArticlesResponseDto.GetAuthorArticlesResponseDtoBuilder()
            .id(articleId2)
            .title(articleTitle2)
            .description(articleDescription2)
            .authorId(authorId)
            .authorFirstName(authorFirstName)
            .authorLastName(authorLastName)
            .build();
    public static final GetPopularArticlesResponseDto popularArticleDto = new GetPopularArticlesResponseDto.GetPopularArticlesResponseDtoBuilder()
            .id(articleId)
            .title(articleTitle)
            .description(articleDescription)
            .numLikes(articleNumLikes8)
            .build();
    public static final GetPopularArticlesResponseDto popularArticleDto2 = new GetPopularArticlesResponseDto.GetPopularArticlesResponseDtoBuilder()
            .id(articleId2)
            .title(articleTitle2)
            .description(articleDescription2)
            .numLikes(articleNumLikes9)
            .build();
    public static final GetArticleInCategoryResponseDto articleInCategoryDto = new GetArticleInCategoryResponseDto.GetArticleInCategoryResponseDtoBuilder()
            .id(articleId)
            .title(articleTitle)
            .description(articleDescription)
            .categoryId(categoryId)
            .categoryName(categoryName)
            .build();

    public static final AuthorDetailsResponseDto authorDetailsDto = new AuthorDetailsResponseDto.GetAuthorDetailsResponseDtoBuilder()
            .id(authorId)
            .firstName(authorFirstName)
            .lastName(authorLastName)
            .email(authorEmail)
            .type(authorType)
            .build();
    public static final AuthorDetailsResponseDto authorDetailsDto2 = new AuthorDetailsResponseDto.GetAuthorDetailsResponseDtoBuilder()
            .id(authorId2)
            .firstName(authorFirstName2)
            .lastName(authorLastName2)
            .email(authorEmail2)
            .type(authorType2)
            .build();
    public static final AuthorDetailsResponseDto authorUpdatedDetailsDto = new AuthorDetailsResponseDto.GetAuthorDetailsResponseDtoBuilder()
            .id(authorId)
            .firstName(authorFirstName2)
            .lastName(authorLastName2)
            .email(authorEmail2)
            .type(authorType2)
            .build();

    public static final List<AuthorDetailsResponseDto> allAuthorsDto = List.of(authorDetailsDto, authorDetailsDto2);

    public static final CreateAuthorRequestDto createAuthorRequestDto = new CreateAuthorRequestDto.CreateAuthorRequestDtoBuilder()
            .firstName(authorFirstName)
            .lastName(authorLastName)
            .email(authorEmail)
            .type(authorType)
            .build();

    public static final UpdateAuthorRequestDto updateAuthorRequestDto = new UpdateAuthorRequestDto.UpdateAuthorRequestDtoBuilder()
            .firstName(authorFirstName)
            .lastName(authorLastName)
            .email(authorEmail)
            .type(authorType)
            .build();

    public static final GetCategoryDetailsResponseDto categoryDto = new GetCategoryDetailsResponseDto.GetCategoryDetailsResponseDtoBuilder()
            .id(categoryId)
            .name(categoryName)
            .description(categoryDescription)
            .authorId(authorId)
            .build();
    public static final GetCategoryDetailsResponseDto categoryDto2 = new GetCategoryDetailsResponseDto.GetCategoryDetailsResponseDtoBuilder()
            .id(categoryId2)
            .name(categoryName2)
            .description(categoryDescription2)
            .authorId(authorId2)
            .build();
    public static final GetCategoryDetailsResponseDto categoryUpdatedDto = new GetCategoryDetailsResponseDto.GetCategoryDetailsResponseDtoBuilder()
            .id(categoryId)
            .name(categoryName2)
            .description(categoryDescription2)
            .authorId(authorId)
            .build();
    public static final GetCategoryDetailsResponseDto categoryAuhtorChangedDto = new GetCategoryDetailsResponseDto.GetCategoryDetailsResponseDtoBuilder()
            .id(categoryId)
            .name(categoryName)
            .description(categoryDescription)
            .authorId(authorId2)
            .build();

    public static final GetAuthorCategoriesResponseDto authorCategoryDto = new GetAuthorCategoriesResponseDto.GetAuthorCategoriesResponseDtoBuilder()
            .id(categoryId)
            .name(categoryName)
            .description(categoryDescription)
            .authorId(authorId)
            .authorFirstName(authorFirstName)
            .authorLastName(authorLastName)
            .build();
    public static final GetAuthorCategoriesResponseDto authorCategoryDto2 = new GetAuthorCategoriesResponseDto.GetAuthorCategoriesResponseDtoBuilder()
            .id(categoryId2)
            .name(categoryName2)
            .description(categoryDescription2)
            .authorId(authorId)
            .authorFirstName(authorFirstName)
            .authorLastName(authorLastName)
            .build();

}
