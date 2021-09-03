package ru.iteco.fmh.converter.news;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.iteco.fmh.dao.repository.NewsCategoryRepository;
import ru.iteco.fmh.dao.repository.UserRepository;
import ru.iteco.fmh.dto.news.NewsDto;
import ru.iteco.fmh.model.news.News;

@Component
@RequiredArgsConstructor
public class NewsDtoToNewsConverter implements Converter<NewsDto, News> {
    private final NewsCategoryRepository newsCategoryRepository;
    private final UserRepository userRepository;

    @Override
    public News convert(NewsDto newsDto) {
        News news = new News();
        BeanUtils.copyProperties(newsDto, news);

        news.setNewsCategory(newsDto.getNewsCategoryId() != 0
                ? newsCategoryRepository.findNewsCategoryById(newsDto.getNewsCategoryId()) : null);
        news.setCreator(newsDto.getCreatorId() != 0
                ? userRepository.findUserById(newsDto.getCreatorId()) : null);

        return news;
    }
}