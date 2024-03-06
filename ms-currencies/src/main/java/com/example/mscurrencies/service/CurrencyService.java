package com.example.mscurrencies.service;

import com.example.mscurrencies.dto.models.cbarClientModel.ValCurs;
import com.example.mscurrencies.dto.models.cbarClientModel.ValType;
import com.example.mscurrencies.dto.models.cbarClientModel.Valute;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Arrays;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE ,makeFinal = true)
public class CurrencyService {

    CbarService cbarService;

    public BigDecimal findPriceOfCurrency(String code , String date){
        ValCurs valCurs = toValCursModel(date);

        ValType type = valCurs.getTypeList().stream()
                .filter(valType -> valType.getType().equals("Xarici valyutalar") ).findFirst().get();

        Valute seachedValute = type.getValuteList().stream()
                .filter(valute -> valute.getCode().equals(code))
                .findFirst().orElseThrow(()->{throw new RuntimeException("there is no valute with this code");});

        BigDecimal priceOfSearchedValute = seachedValute.getPrice().divide(BigDecimal.valueOf(Long.parseLong(seachedValute.getNominal())));

        return priceOfSearchedValute;
    }

    @SneakyThrows
    private ValCurs toValCursModel(String date){

        JAXBContext jaxbContext = JAXBContext.newInstance(ValCurs.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        ValCurs valCurs = (ValCurs) unmarshaller.unmarshal(new StringReader(cbarService.getData(date)));

        addAZNCode(valCurs);

        return valCurs;

    }

    private void addAZNCode(ValCurs valCurs){
        ValType type = valCurs.getTypeList().stream()
                .filter(valType -> valType.getType().equals("Xarici valyutalar") ).findFirst().get();

        for (ValType valtype : valCurs.getTypeList()){
            if (valtype.equals(type))
                type=valtype;
        }

        type.getValuteList().add(Valute.builder()
                .code("AZN")
                .nominal("1")
                .name("1 Azerbaycan manati")
                .price(BigDecimal.ONE)
                .build());
    }



//    @SneakyThrows
//    public void marshalToXML(){
//
//        ValCurs valCurs = ValCurs.builder()
//                .date("12.33.2222")
//                .description("currency holder")
//                .name("asl")
//                .typeList(Arrays.asList(ValType.builder()
//                                .type("type1")
//                                .valuteList(Arrays.asList(Valute.builder()
//                                                .price(BigDecimal.valueOf(343))
//                                                .name("name1")
//                                                .nominal("nominal1")
//                                                .code("code1")
//                                                .build(),
//                                        Valute.builder()
//                                                .price(BigDecimal.valueOf(343))
//                                                .name("name2")
//                                                .nominal("nominal2")
//                                                .code("code2")
//                                                .build()))
//                                .build(),
//                        ValType.builder()
//                                .type("type2")
//                                .valuteList(Arrays.asList(Valute.builder()
//                                                .price(BigDecimal.valueOf(343))
//                                                .name("name3")
//                                                .nominal("nominal3")
//                                                .code("code3")
//                                                .build(),
//                                        Valute.builder()
//                                                .price(BigDecimal.valueOf(343))
//                                                .name("name4")
//                                                .nominal("nominal4")
//                                                .code("code4")
//                                                .build()))
//                                .build()))
//                .build();
//
//        JAXBContext context = JAXBContext.newInstance(ValCurs.class);
//        Marshaller mar= context.createMarshaller();
//        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//        mar.marshal((Object) valCurs, new File("C:\\Users\\Lenovo\\Desktop\\jaxb.xml\\jaxb.xml"));
//
//    }
    }
