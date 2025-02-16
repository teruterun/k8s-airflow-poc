//package com.example.batchsample.config;
//
//import com.example.batchsample.processor.SalesProcessor;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.job.builder.JobBuilder;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class BatchConfig {
//
//    @Bean
//    @StepScope
//    public SalesProcessor salesProcessor(@Value("#{jobParameters['productData']}") String productData) {
//        return new SalesProcessor(productData);
//    }
//    
////    @Bean
////    public Job salesJob(JobRepository jobRepository, Step salesStep) {
////        return new JobBuilder("salesJob", jobRepository)
////                .incrementer(new RunIdIncrementer())
////                .start(salesStep)
////                .build();
////    }
//
//}
//
//
////import com.example.batchsample.batch.entity.Sales;
////import com.example.batchsample.processor.SalesProcessor;
////import com.example.batchsample.batch.entity.Product;
////import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
////import org.springframework.batch.core.configuration.annotation.StepScope;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.core.io.ClassPathResource;
////import org.springframework.batch.item.file.FlatFileItemReader;
////import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
////import org.springframework.batch.item.file.mapping.DefaultLineMapper;
////import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
////import org.springframework.beans.factory.annotation.Value;
////
////@Configuration
////public class BatchConfig {
////	
////	@Bean
////	public SalesProcessor salesProcessor(FlatFileItemReader<Product> productItemReader) throws Exception {
////	    return new SalesProcessor(productItemReader);
////	}
////
////
////    @Bean
////    public FlatFileItemReader<Sales> salesItemReader() {
////        FlatFileItemReader<Sales> reader = new FlatFileItemReader<>();
////        reader.setResource(new ClassPathResource("data/sales.csv"));
////        reader.setLinesToSkip(1); // ヘッダーをスキップ
////        reader.setLineMapper(new DefaultLineMapper<Sales>() {{
////            setLineTokenizer(new DelimitedLineTokenizer() {{
////                setNames("salesId", "productId", "quantity", "date");
////                setDelimiter(",");
////            }});
////            setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
////                setTargetType(Sales.class);
////            }});
////        }});
////        return reader;
////    }
////
////    @Bean
////    @StepScope
////    public FlatFileItemReader<Product> productItemReader(@Value("#{jobParameters['productFile']}") String productFilePath) {
////        FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
////        reader.setResource(new ClassPathResource(productFilePath));
////        reader.setLinesToSkip(1);
////        reader.setLineMapper(new DefaultLineMapper<Product>() {{
////            setLineTokenizer(new DelimitedLineTokenizer() {{
////                setNames("productId", "name", "price");
////                setDelimiter(",");
////            }});
////            setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
////                setTargetType(Product.class);
////            }});
////        }});
////        return reader;
////    }
////}
