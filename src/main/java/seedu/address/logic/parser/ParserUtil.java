package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.customer.AddressCustomer;
import seedu.address.model.customer.EmailCustomer;
import seedu.address.model.customer.NameCustomer;
import seedu.address.model.customer.PhoneCustomer;
import seedu.address.model.dish.NameDish;
import seedu.address.model.dish.PriceDish;
import seedu.address.model.driver.DriverStatus;
import seedu.address.model.driver.NameDriver;
import seedu.address.model.driver.PhoneDriver;
import seedu.address.model.item.Name;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";
    public static final String MESSAGE_INVALID_DRIVER_STATUS = "This driver status is invalid.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code NameCustomer}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static NameCustomer parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!NameCustomer.isValidName(trimmedName)) {
            throw new ParseException(NameCustomer.MESSAGE_CONSTRAINTS);
        }
        return new NameCustomer(trimmedName);
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static NameDish parseDishName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!NameDish.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new NameDish(trimmedName);
    }


    /**
     * Parses a {@code String name} into a {@code NameDriver}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static NameDriver parseNameDriver(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!NameDriver.isValidName(trimmedName)) {
            throw new ParseException(NameDriver.MESSAGE_CONSTRAINTS);
        }
        return new NameDriver(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code PhoneCustomer}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static PhoneCustomer parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!PhoneCustomer.isValidPhone(trimmedPhone)) {
            throw new ParseException(PhoneCustomer.MESSAGE_CONSTRAINTS);
        }
        return new PhoneCustomer(trimmedPhone);
    }

    /**
     * Parses a {@code String phone} into a {@code PhoneDriver}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static PhoneDriver parsePhoneDriver(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!PhoneDriver.isValidPhone(trimmedPhone)) {
            throw new ParseException(PhoneDriver.MESSAGE_CONSTRAINTS);
        }
        return new PhoneDriver(trimmedPhone);
    }

    /**
     * Parses a {@code String status} into a {@code DriverStatus}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code status} is invalid.
     */
    public static DriverStatus parseDriverStatus (String status) throws ParseException {
        requireNonNull(status);
        String trimmedStatus = status.trim();
        for (DriverStatus driverStatus : DriverStatus.values()) {
            if (driverStatus.name().equalsIgnoreCase(trimmedStatus)) {
                return DriverStatus.valueOf(trimmedStatus.toUpperCase());
            }
        }
        throw new ParseException(MESSAGE_INVALID_DRIVER_STATUS);
    }


    /**
     * Parses a {@code String address} into an {@code AddressCustomer}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static AddressCustomer parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!AddressCustomer.isValidAddress(trimmedAddress)) {
            throw new ParseException(AddressCustomer.MESSAGE_CONSTRAINTS);
        }
        return new AddressCustomer(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code EmailCustomer}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static EmailCustomer parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!EmailCustomer.isValidEmail(trimmedEmail)) {
            throw new ParseException(EmailCustomer.MESSAGE_CONSTRAINTS);
        }
        return new EmailCustomer(trimmedEmail);
    }

    /**
     * Parses a {@code String price} into a {@code PriceDish}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code price} is invalid.
     */
    public static PriceDish parsePrice(String price) throws ParseException {
        requireNonNull(price);
        String trimmedPrice = price.trim();
        if (!PriceDish.isValidPrice(trimmedPrice)) {
            throw new ParseException(PriceDish.MESSAGE_CONSTRAINTS);
        }
        return new PriceDish(trimmedPrice);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }
}
